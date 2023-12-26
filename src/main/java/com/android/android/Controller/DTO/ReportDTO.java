package com.android.android.Controller.DTO;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class ReportDTO {
    private Integer countOrder;
    private Double avvSum;
    private List<SneakerCountPair> listPopularSneaker;
    private List<ExpandedOrderDTO> listOrder;

    public ReportDTO(Integer countOrder, Double avvSum, List<SneakerCountPair> listPopularSneaker, List<ExpandedOrderDTO> listOrder){
        this.countOrder = countOrder;
        this.avvSum = avvSum;
        this.listPopularSneaker = listPopularSneaker;
        this.listOrder = listOrder;
    }
}
