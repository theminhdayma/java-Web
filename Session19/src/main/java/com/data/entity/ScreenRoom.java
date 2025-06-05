package com.data.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import java.util.List;

@Entity
@Table(name = "screen_room")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ScreenRoom {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Tên phòng chiếu không được để trống")
    @Column(nullable = false)
    private String roomName;

    @Min(value = 1, message = "Sức chứa phải lớn hơn 0")
    private Integer capacity;

    @NotBlank(message = "Loại màn hình không được để trống")
    @Pattern(regexp = "^(2D|3D|IMAX)$", message = "Loại màn hình phải là 2D, 3D hoặc IMAX")
    private String screenType;

    @Column(nullable = false)
    private Boolean status = true;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "theater_id")
    private Theater theater;

    @OneToMany(mappedBy = "screenRoom", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Seat> seats;
}