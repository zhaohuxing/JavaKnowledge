package com.sprint.interfaces;

public interface Food { //对于枚举而言使用接口实现子类化
	enum Appetizer implements Food {
		SALAD, SOUP, SPRING_ROLLS;	
	}
	enum MainCourse implements Food {
		LASAGNE, BURRITO, PAD_THAI, LENTIKLS;
	}
	enum Dessert implements Food {
		TIRAMISU, GELATO, BLACK_COFFEE;
	}
	enum Coffee implements Food {
		BLACK_COFFEE, DECAF_COFFEE, ESPRESSO;
	}
}
