package designpatterns.builder;

import java.util.Date;
import java.util.Set;

public interface PromotionBuilder {
	
	public void buildArticles(Set<Article> articles);
	public void buildPromotionDates(Date startDate, Date endDate);
	public void buildPromotionRemarks(String remarks);
	public void buildPromotionType(PromotionType promotionType);
	public Promotion buildPromotion();

}
