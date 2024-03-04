package FirstLaboratory.Account.Client;

import FirstLaboratory.Services.Notification;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Client {
    private final String _id;
    private String _firstName;
    private String _lastName;
    private Address _address;
    private Passport passport;
    protected List<Notification> _notifications;
    private boolean _suspicious;

    public Client(String newFirstName, String newLastName) {
        _id = UUID.randomUUID().toString();
        _firstName = newFirstName;
        _lastName = newLastName;
        _suspicious = true;
        _notifications = new ArrayList<>();
    }

    public String GetId() {
        return _id;
    }

    public void SetFirstName(String newFirstName){
        _firstName = newFirstName;
    }

    public String GetFirstName(){
        return _firstName;
    }

    public void SetLastName(String newLastName){
        _lastName = newLastName;
    }

    public String GetLastName(){
        return _lastName;
    }

    public void SetAddress(Address newAddress){
        _address = newAddress;
    }

    public Address GetAddress(){
        return _address;
    }

    public void SetPassport(Passport newPassport){
        passport = newPassport;
    }

    public Passport GetPassport(){
        return passport;
    }

    public boolean IsConfirmed() {
        return _suspicious;
    }

    public void UpdateInfo(Address newAddress, Passport newPassport) {
        _address = newAddress;
        passport = newPassport;
        _suspicious = false;
    }

    public void ReceiveNotification(Notification notification) {
        _notifications.add(notification);
    }
}
