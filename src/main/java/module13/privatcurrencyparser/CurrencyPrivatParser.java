package module13.privatcurrencyparser;

import com.google.gson.Gson;
import org.jsoup.Jsoup;

import java.io.IOException;

public class CurrencyPrivatParser {
    private static final String PRIVAT_API = "https://api.privatbank.ua/p24api/pubinfo?exchange&coursid=5";
    private static final Gson GSON = new Gson().newBuilder().setPrettyPrinting().create();

    public float getBuyRate(CCY ccy) {
        try {
            String text = Jsoup.connect(PRIVAT_API)
                    .ignoreContentType(true)
                    .get()
                    .body()
                    .text();

            CurrencyItem[] currencyItems = GSON.fromJson(text, CurrencyItem[].class);
            for (CurrencyItem currencyItem : currencyItems) {
                if (currencyItem.ccy().equals(ccy)) {
                    return currencyItem.buy();
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return -1F;
    }

    public float getSaleRate(CCY ccy) {
        try {
            String text = Jsoup.connect(PRIVAT_API)
                    .ignoreContentType(true)
                    .get()
                    .body()
                    .text();

            CurrencyItem[] currencyItems = GSON.fromJson(text, CurrencyItem[].class);
            for (CurrencyItem currencyItem : currencyItems) {
                if (currencyItem.ccy().equals(ccy)) {
                    return currencyItem.sale();
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return -1F;
    }
}

