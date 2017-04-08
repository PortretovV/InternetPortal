package ru.portvitaly.EJB;

import ru.portvitaly.entity.Lot;

import javax.ejb.Singleton;
import javax.enterprise.event.Observes;
import javax.inject.Named;

@Singleton
@Named
public class BasketSingleton {
    private String textAboutProduct;

    public String getTextAboutProduct() {
        return textAboutProduct;
    }

    public void handleInsertEvent(@Observes Lot lot) {
        textAboutProduct = String.format("Товар %s был добавлен в корзину. В количестве %d штук. Сумма этих товаров %d"
                ,lot.getProduct().getArticle(),lot.getCount(),(lot.getCount()*lot.getProduct().getCost()) );
    }

}
