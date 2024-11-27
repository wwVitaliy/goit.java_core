package module13.privatcurrencyparser;

public class CurrencyPrivatParserTests {
    public static void main(String[] args) {
        CurrencyPrivatParser currencyPrivatParser = new CurrencyPrivatParser();
        System.out.println("USD.buy = " + currencyPrivatParser.getBuyRate(CCY.USD));
        System.out.println("USD.sale = " + currencyPrivatParser.getSaleRate(CCY.USD));
        System.out.println("EUR.buy = " + currencyPrivatParser.getBuyRate(CCY.EUR));
        System.out.println("EUR.sale = " + currencyPrivatParser.getSaleRate(CCY.EUR));

        System.out.println("UAH.sale = " + currencyPrivatParser.getSaleRate(CCY.UAH));
    }
}
