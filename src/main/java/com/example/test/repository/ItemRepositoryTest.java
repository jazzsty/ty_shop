package com.example.test.repository;

import java.time.LocalDateTime;
import java.util.List;

//import org.junit.jupiter.*;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.example.item.constant.ItemSellStatus;
import com.example.item.entity.Item;
import com.example.item.repository.ItemRepository;

class ItemRepositoryTest {
	
	@Autowired
	ItemRepository itemRepository;
	
	public void createItemList() {
		System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
		for(int i=1; i<=10; i++) {
			Item item = new Item();
			item.setItemNm("테스트 상품" + i);
			item.setPrice(10000 + i);
			item.setItemDetail("테스트 상품 상세 설명" + i);
			item.setItemSellStatus(ItemSellStatus.SELL);
			item.setStockNumber(100);
			item.setRegTime(LocalDateTime.now());
			item.setUpdateTime(LocalDateTime.now());
			
			itemRepository.save(item);
		}
		System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
	}
	
	@Test
//	@DisplayName("상품명 조회 테스트")
	public void findByItemNmTest() {
		this.createItemList();
		List<Item> itemList = itemRepository.findByItemNm("테스트 상품1");
		for(Item item : itemList) {
			System.out.println(item.toString());
		}
	}
	
	@Test
	void test() {
		Item item = new Item();
		System.out.println(item);
	}
}
