package designpatterns.builder;

public class PromotionCreator {

	private PromotionBuilder promotionBuilder;
	
	public PromotionCreator(PromotionBuilder promotionBuilder){
		this.promotionBuilder = promotionBuilder;
	}
	
	public void createPromotion(){
		promotionBuilder.buildArticles(articles);
	}
	
	
}
