package exceptions;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class CoinNotFoundException extends RuntimeException {

    public CoinNotFoundException(String message) {
        super(message);
    }

}
