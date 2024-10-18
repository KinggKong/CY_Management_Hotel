package org.example.cy_vn_managementhotel.servlet.admin;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;
import org.example.cy_vn_managementhotel.dto.RoomRequest;
import org.example.cy_vn_managementhotel.entity.Hotel;
import org.example.cy_vn_managementhotel.entity.TypeRoom;
import org.example.cy_vn_managementhotel.mapper.HotelMapper;
import org.example.cy_vn_managementhotel.mapper.TypeRoomMapper;
import org.example.cy_vn_managementhotel.service.impl.HotelService;
import org.example.cy_vn_managementhotel.service.impl.RoomService;
import org.example.cy_vn_managementhotel.service.impl.TypeRoomService;

import java.io.File;
import java.io.IOException;

@WebServlet({"/admin/home",
        "/admin/add",
        "/admin/update",
        "/admin/dashboard"
})
@MultipartConfig(
        fileSizeThreshold = 1024 * 1024,
        maxFileSize = 5 * 1024 * 1024,
        maxRequestSize = 10 * 1024 * 1024
)
public class HomeAdminServlet extends HttpServlet {
    private final String FOLDER = "static";
    HotelService hotelService = new HotelService();
    TypeRoomService typeRoomService = new TypeRoomService();
    RoomService roomService = new RoomService();


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String uri = req.getRequestURI();
        switch (uri) {
            case "/admin/home":
                req.getRequestDispatcher("/views/homeAdmin.jsp").forward(req, resp);
                break;
            default:
                req.getRequestDispatcher("/views/NotFound.jsp").forward(req, resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String uri = req.getRequestURI();
        switch (uri) {
            case "/admin/add":
                addRoom(req, resp);
                break;
            default:
                req.getRequestDispatcher("/views/NotFound.jsp").forward(req, resp);
        }
    }

    private void addRoom(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        double price = Double.parseDouble(req.getParameter("price"));
        String description = req.getParameter("description");
        int numberOfBed = Integer.parseInt(req.getParameter("numberOfBed"));
        Part filePart = req.getPart("image");
        String image = uploadFile(filePart, req);
        int numberOfPerSon = Integer.parseInt(req.getParameter("numberOfPerson"));
        Long idHotel = Long.parseLong(req.getParameter("hotel"));
        Hotel hotel = HotelMapper.toHotel(hotelService.findById(idHotel));
        Long idTypeRoom = Long.parseLong(req.getParameter("typeRoom"));
        TypeRoom typeRoom = TypeRoomMapper.toTypeRoom(typeRoomService.findById(idTypeRoom));
        String status = req.getParameter("status");
        RoomRequest room = RoomRequest.builder()
                .price(price)
                .description(description)
                .rate(0)
                .status(status)
                .hotel(hotel)
                .typeRoom(typeRoom)
                .numberOfBed(numberOfBed)
                .numberOfPerson(numberOfPerSon)
                .image(image)
                .name(name)
                .build();
        int result = roomService.addRoom(room);
    }

    public String uploadFile(Part filePart, HttpServletRequest req) throws IOException, ServletException {
//        String uploadPath = "G:\\Work\\JAVA\\Practice\\demoUploadFile\\src\\main\\webapp" + File.separator + FOLDER;
        String uploadPath = req.getServletContext().getRealPath("/resources") + File.separator + FOLDER;
        String fileName = filePart.getSubmittedFileName();

        File uploadDir = new File(uploadPath);
        if (!uploadDir.exists()) {
            if (uploadDir.mkdirs()) {
                System.out.println("Directory created successfully: " + FOLDER);
            } else {
                System.out.println("Failed to create directory: " + FOLDER);
            }
        }
        for (Part part : req.getParts()) {
            part.write(uploadPath + File.separator + fileName);
        }
        return "/resources/static/" + fileName;
    }

}
