package com.data.session16.dto;

import com.data.session16.model.BusType;

import org.springframework.web.multipart.MultipartFile;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.*;
@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor
public class BusDto {

    private int id;

    @NotBlank(message = "Biển số xe không được để trống")
    private String licensePlate;

    @NotNull(message = "Vui lòng chọn loại xe")
    private BusType busType;

    @Min(value = 1, message = "Số hàng ghế phải lớn hơn 0")
    private int rowSeat;

    @Min(value = 1, message = "Số cột ghế phải lớn hơn 0")
    private int colSeat;

    private int totalSeat;

    @NotNull(message = "Vui lòng chọn hình ảnh")
    private MultipartFile image;


}
