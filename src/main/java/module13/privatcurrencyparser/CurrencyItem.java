package module13.privatcurrencyparser;

public record CurrencyItem(
        CCY ccy,
        CCY base_ccy,
        float buy,
        float sale
) {

    public CurrencyItem(CCY ccy, float buy, float sale) {
        this(ccy, CCY.UAH, buy, sale);
    }
}
