package com.data.session12.dto;

import com.data.session12.model.Status;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import lombok.*;

@NoArgsConstructor
@Getter
@Setter
@AllArgsConstructor
public class ProductDto {

    @NotBlank(message = "Tên sản phẩm không được để trống")
    private String name;

    @NotNull(message = "Giá sản phẩm không được để trống")
    @Min(value = 0, message = "Giá phải lớn hơn hoặc bằng 0")
    private Double price;

    private String description;

    private MultipartFile image;

    @NotNull(message = "Trạng thái không được để trống")
    private Status status;

}
