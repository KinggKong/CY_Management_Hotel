package org.example.cy_vn_managementhotel.servlet.user;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.example.cy_vn_managementhotel.dto.BillDetailRequest;
import org.example.cy_vn_managementhotel.dto.BillRequest;
import org.example.cy_vn_managementhotel.entity.Room;
import org.example.cy_vn_managementhotel.entity.StatusBill;
import org.example.cy_vn_managementhotel.entity.User;
import org.example.cy_vn_managementhotel.mapper.RoomMapper;
import org.example.cy_vn_managementhotel.model.AccountResponse;
import org.example.cy_vn_managementhotel.model.AddressResponse;
import org.example.cy_vn_managementhotel.model.Common;
import org.example.cy_vn_managementhotel.model.RoomResponse;
import org.example.cy_vn_managementhotel.service.impl.*;
import org.example.cy_vn_managementhotel.utils.LocalDateTimeAdapter;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.Random;

@WebServlet({"/",
        "/main_room",
        "/login",
        "/room_detail",
        "/booking",
})
public class HomeServlet extends HttpServlet {
    RoomService roomService = new RoomService();
    AccountService accountService = new AccountService();
    AddressService addressService = new AddressService();
    BillService billService = new BillService();
    BillDetailService billDetailService = new BillDetailService();

    private Gson gson = new GsonBuilder()
            .registerTypeAdapter(LocalDateTime.class, new LocalDateTimeAdapter())
            .create();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String uri = req.getRequestURI();
        switch (uri) {
            case "/":
                trangChu(req, resp);
                break;
            case "/main_room":
                pagination(req, resp);
                break;
            case "/login":
                req.getRequestDispatcher("/views/login.jsp").forward(req, resp);
                break;
            case "/room_detail":
                roomDetail(req, resp);
                break;
            case "/booking":
                booking(req, resp);
                break;
            default:
                req.getRequestDispatcher("/views/NotFound.jsp").forward(req, resp);
        }

    }


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String uri = req.getRequestURI();
        switch (uri) {
            case "/login":
                login(req, resp);
                break;
            case "/search":
                searchByLocationAndDate(req, resp);
                break;
            case "/payment":
                payment(req, resp);
                break;
            default:
                req.getRequestDispatcher("/views/NotFound.jsp").forward(req, resp);
        }
    }


    public void trangChu(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<AddressResponse> addressResponses = addressService.findAllProvince();
        req.setAttribute("provinces", addressResponses);
        req.getRequestDispatcher("/views/home.jsp").forward(req, resp);
    }

    public void pagination(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter out = resp.getWriter();
        String checkin = req.getParameter("checkin");
        String checkout = req.getParameter("checkout");
        LocalDateTime checkinDate;
        LocalDateTime checkoutDate;
        if (checkin == null || checkin.equals("") || checkout == null || checkout.equals("")) {
            checkinDate = LocalDateTime.now();
            checkoutDate = LocalDateTime.now();
        } else {
            checkinDate = convertToLocalDateTime(checkin);
            checkoutDate = convertToLocalDateTime(checkout);
        }


        String page = req.getParameter("page");
        int pageNumber = 0;

        if (page == null || page.equals("")) {
            pageNumber = 0;
        } else {
            pageNumber = Integer.parseInt(page);
            if (pageNumber < 0) {
                pageNumber = 0;
            }
        }

        List<RoomResponse> rooms = roomService.paginationRoomAvailable(pageNumber - 1, 10, checkinDate, checkoutDate);
        Long count = roomService.countAllRooms();
        int totalPage = (int) Math.ceil((double) count / 10);

        Common common = Common.builder()
                .list(rooms)
                .totalPage(totalPage)
                .pageIndex(pageNumber)
                .totalItem(10)
                .build();

        String productJson = gson.toJson(common);
        resp.setContentType("application/json");
        resp.setCharacterEncoding("UTF-8");

        out.print(productJson);
        out.flush();
    }

    public void login(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String email = req.getParameter("email");
        String password = req.getParameter("password");
        AccountResponse accountResponse = accountService.checkLogin(email, password);
        if (accountResponse != null) {
            req.getSession().setAttribute("authenticated", accountResponse);
            resp.sendRedirect(req.getContextPath() + "/");
        } else {
            req.getRequestDispatcher("/views/login.jsp").forward(req, resp);
        }
    }

    public void roomDetail(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String roomId = req.getParameter("id");
        if (roomId == null || roomId.equals("")) {
            req.getRequestDispatcher("/views/NotFound.jsp").forward(req, resp);
        }
        Long id = Long.parseLong(roomId);
        String checkin = req.getParameter("checkin");
        String checkout = req.getParameter("checkout");
        if (checkin == null || checkin.equals("") || checkout == null || checkout.equals("")) {

            req.setAttribute("checkin", LocalDate.now());
            req.setAttribute("checkout", LocalDate.now());
        } else {
            req.setAttribute("checkin", checkin);
            req.setAttribute("checkout", checkout);
        }
        RoomResponse roomResponse = roomService.findById(id);
        req.setAttribute("room", roomResponse);
        req.getRequestDispatcher("/views/detail.jsp").forward(req, resp);
    }

    public void searchByLocationAndDate(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter out = resp.getWriter();
        String location = req.getParameter("location");
        Long idLocation = Long.parseLong(req.getParameter("location"));
        LocalDate date = LocalDate.parse(req.getParameter("date"));
        String page = req.getParameter("page");
        int pageNumber = 0;

        if (page == null || page.equals("")) {
            pageNumber = 0;
        } else {
            pageNumber = Integer.parseInt(page);
            if (pageNumber < 0) {
                pageNumber = 0;
            }
        }
        Long count = roomService.countAllSearch(idLocation, date);
        int pageSize = 10;
        int totalPage = (int) Math.ceil((double) count / 5);
        List<RoomResponse> roomResponses = roomService.searchByLocationAndDate(idLocation, date, pageSize, pageNumber - 1);
        Common common = Common.builder()
                .list(roomResponses)
                .totalPage(totalPage)
                .pageIndex(pageNumber)
                .totalItem(10)
                .build();

        String productJson = gson.toJson(common);
        resp.setContentType("application/json");
        resp.setCharacterEncoding("UTF-8");

        out.print(productJson);
        out.flush();
    }

    private void booking(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
        if (id == null || id.equals("")) {
            req.getRequestDispatcher("/views/NotFound.jsp").forward(req, resp);
        }
        Long idRoom = Long.parseLong(id);
        String checkin = req.getParameter("checkin");
        String checkout = req.getParameter("checkout");
        req.setAttribute("checkin", checkin);
        req.setAttribute("checkout", checkout);

        LocalDate checkinDate = LocalDate.parse(checkin);
        LocalDate checkoutDate = LocalDate.parse(checkout);

        long numberDay = ChronoUnit.DAYS.between(checkinDate, checkoutDate);

        req.setAttribute("numberDay", numberDay);
        RoomResponse roomResponse = roomService.findById(idRoom);
        req.setAttribute("room", roomResponse);
        req.getRequestDispatcher("/views/payInformation.jsp").forward(req, resp);
    }

    private void payment(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String customerName = req.getParameter("customerName");
        String customerPhone = req.getParameter("customerPhone");
        String note = req.getParameter("note");
        String codeBill = generateCode();
        String totalPrice = req.getParameter("totalPrice");
        double totalAmount = Double.parseDouble(totalPrice);
        User user = User.builder()
                .id(1L)
                .build();
        BillRequest billRequest = BillRequest.builder()
                .customerName(customerName)
                .customerPhone(customerPhone)
                .note(note)
                .codeBill(codeBill)
                .user(user)
                .status(1)
                .totalPrice(totalAmount)
                .build();
        int resultBill = billService.insertBill(billRequest);
        if (resultBill != 0) {
            String price = req.getParameter("price");
            double priceNum = Double.parseDouble(price);
            String checkin = req.getParameter("checkin");
            String checkout = req.getParameter("checkout");
            String idRoom = req.getParameter("idRoom");
            LocalDateTime checkinDate = convertToLocalDateTime(checkin);
            LocalDateTime checkoutDate = convertToLocalDateTime(checkout);
            Long roomId = Long.parseLong(idRoom);
            Room room = RoomMapper.toRoom(roomService.findById(roomId));
            String typeRoom = req.getParameter("typeRoom");
            BillDetailRequest billDetailRequest = BillDetailRequest.builder()
                    .room(room)
                    .price(priceNum)
                    .typeRoom(typeRoom)
                    .checkin(checkinDate)
                    .checkout(checkoutDate)
                    .codeBill(codeBill)
                    .status(1)
                    .build();
            billDetailService.insertBillDetail(billDetailRequest);
        }
        req.getRequestDispatcher("/views/donePayment.jsp").forward(req, resp);
    }

    public LocalDateTime convertToLocalDateTime(String dateString) {
        LocalDate localDate = LocalDate.parse(dateString);
        LocalDateTime localDateTime = localDate.atStartOfDay();
        return localDateTime;
    }

    private String generateCode() {
        Random random = new Random();
        StringBuilder code = new StringBuilder();
        for (int i = 0; i < 15; i++) {
            code.append(random.nextInt(10));
        }
        return code.toString();
    }
}
