package br.com.alura.loja;

public class DomainException extends RuntimeException {

    static final long serialVersionUID = 1L;

    public DomainException(String message) {
        super(message);
    }
}
