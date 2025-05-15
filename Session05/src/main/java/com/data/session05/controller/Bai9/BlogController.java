package com.data.session05.controller.Bai9;

import com.data.session05.model.Bai9.Post;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet(name = "BlogController", value = "/blog")
public class BlogController extends HttpServlet {
    private List<Post> posts = new ArrayList<>();

    @Override
    public void init() throws ServletException {
        posts.add(new Post(1, "Giới thiệu JSP", "JSP là công nghệ tạo trang web động.", "Nguyễn Văn A", "2024-05-01"));
        posts.add(new Post(2, "Servlet cơ bản", "Servlet xử lý request và response.", "Trần Thị B", "2024-05-02"));
        posts.add(new Post(3, "Hiểu về MVC", "MVC giúp tách logic xử lý và giao diện.", "Lê Văn C", "2024-05-03"));
        posts.add(new Post(4, "Session vs Cookie", "Session và Cookie lưu trạng thái người dùng.", "Phạm Thị D", "2024-05-04"));
        posts.add(new Post(5, "Kết nối CSDL với JDBC", "JDBC giúp kết nối và truy vấn CSDL.", "Ngô Quang E", "2024-05-05"));
        posts.add(new Post(6, "Làm việc với Form", "Cách xử lý form trong JSP và Servlet.", "Bùi Thiên F", "2024-05-06"));
        posts.add(new Post(7, "Xử lý lỗi trong web", "Try-catch và trang lỗi tùy chỉnh.", "Hoàng Minh G", "2024-05-07"));
        posts.add(new Post(8, "Sử dụng include và forward", "Tái sử dụng nội dung với include.", "Đặng Thu H", "2024-05-08"));
        posts.add(new Post(9, "Tìm hiểu Filter", "Filter lọc request trước khi đến Servlet.", "Vũ Hoàng I", "2024-05-09"));
        posts.add(new Post(10, "Triển khai ứng dụng lên Tomcat", "Hướng dẫn deploy WAR lên Tomcat.", "Lý Minh J", "2024-05-10"));
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String postIdParam = request.getParameter("id");

        if (postIdParam != null) {
            int postId = Integer.parseInt(postIdParam);
            for (Post p : posts) {
                if (p.getId() == postId) {
                    request.setAttribute("post", p);
                    request.getRequestDispatcher("views/Bai9/postDetail.jsp").forward(request, response);
                    return;
                }
            }
            response.sendError(HttpServletResponse.SC_NOT_FOUND);
        } else {
            request.setAttribute("posts", posts);
            request.getRequestDispatcher("views/Bai9/postList.jsp").forward(request, response);
        }
    }
}