package ua.lviv.iot.exception;

public class IpAddressNotFoundException extends RuntimeException {
    public IpAddressNotFoundException(Integer id) {
        super("Could not find 'ipAddress' with id=" + id);
    }
}
