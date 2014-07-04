package designpatterns.builder;

import java.util.Date;
import java.util.Set;

public class BXGXPromotionBuilder implements PromotionBuilder {

	private Promotion promotion;
		
	public BXGXPromotionBuilder(){
		promotion = new Promotion();
	}
	
	public void buildArticles(Set<Article> articles) {		
		promotion.setArticles(articles);
	}

	public void buildPromotionDates(Date startDate, Date endDate) {
		promotion.setStartDate(startDate);
		promotion.setEndDate(endDate);
		
	}

	public void buildPromotionRemarks(String remarks) {
		promotion.setRemarks(remarks);		
	}

	public void buildPromotionType(PromotionType promotionType) {
		promotion.setPromotionType(promotionType);		
	}

	public Promotion buildPromotion() {
		return this.promotion;
	}

}
