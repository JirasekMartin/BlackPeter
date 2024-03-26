

public class Card {
    private int cardNumber; // každá karta má různé číslo
    private int pairNumber; // každý pár má různé číslo, jen dvě karty mají stejné číslo páru

    public Card(int cardNumber, int pairNumber) {
        this.cardNumber = cardNumber;
        this.pairNumber = pairNumber;
    }

    public int getCardNumber() {
        return cardNumber;
    }

    public int getPairNumber() {
        return pairNumber;
    }
}