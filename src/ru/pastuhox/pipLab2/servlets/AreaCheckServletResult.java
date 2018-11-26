package ru.pastuhox.pipLab2.servlets;

import lombok.Builder;
import lombok.Data;


@Data
@Builder
public class AreaCheckServletResult
{
    private String x;
    private String y;
    private String r;
    private String isIn;
    private String date;
}
