package com.example.item.entity;

import java.time.LocalDateTime;

import com.example.item.constant.ItemSellStatus;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "item")
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Item {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "item_id")
	private Long id;	// 상품 코드
	
	@Column(nullable = false, length = 50)
	private String itemNm;	//상품명
	
	@Column(nullable = false)
	private int price;		// 상품가격
	
	@Column(nullable = false, name = "number")
	private int stockNumber; 	// 재고수량
	
	@Enumerated(EnumType.STRING)
	private ItemSellStatus itemSellStatus;
	
	@Lob
	@Column(nullable = false)
	private String itemDetail;	// 상품재고설명
	
	private LocalDateTime regTime; 		// 등록 시간
	private LocalDateTime updateTime; 	// 수정시간
	
}
