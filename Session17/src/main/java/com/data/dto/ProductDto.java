package com.data.dto;

import lombok.*;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@NoArgsConstructor
@Getter
@Setter
@AllArgsConstructor
public class ProductDto {
    private int id;
    @NotBlank(message = "Tên sản phẩm không được để trống")
    private String productName;
    private String description;
    @Min(value = 0, message = "Giá sản phẩm phải lớn hơn hoặc bằng 0")
    @NotNull(message = "Giá sản phẩm không được để trống")
    private Double price;
    private int stock;
    private MultipartFile image;
}
