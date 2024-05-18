import org.example.dao.HibernateIOwnerDAO;
import org.example.model.Cat;
import org.example.model.Owner;
import org.example.model.Sex;
import org.example.service.OwnerService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class OwnerControllerTest {
    private List<Cat> cats;
    @Test
    public void testGetOwner() {
        HibernateIOwnerDAO ownerDAO = Mockito.mock(HibernateIOwnerDAO.class);
        OwnerService ownerService = new OwnerService(ownerDAO);

        Owner owner = new Owner("Test Owner", new Date(), Sex.NON_BINARY, cats);

        when(ownerDAO.findById(1)).thenReturn(owner);

        Owner result = ownerService.getOwner(1);
        assertEquals(owner, result);

        verify(ownerDAO, times(1)).findById(1);
    }

    @Test
    public void testSaveOwner() {
        HibernateIOwnerDAO ownerDAO = Mockito.mock(HibernateIOwnerDAO.class);
        OwnerService ownerService = new OwnerService(ownerDAO);

        Owner owner = new Owner("Test Owner", new Date(), Sex.TRANS, cats);

        when(ownerDAO.findById(1)).thenReturn(owner);

        ownerService.saveOwner(owner);

        verify(ownerDAO, times(1)).save(owner);
    }

    @Test
    public void testUpdateOwner() {
        HibernateIOwnerDAO ownerDAO = Mockito.mock(HibernateIOwnerDAO.class);
        OwnerService ownerService = new OwnerService(ownerDAO);

        Owner owner = new Owner("Test Owner", new Date(), Sex.NON_BINARY, cats);

        when(ownerDAO.findById(1)).thenReturn(owner);

        ownerService.saveOwner(owner);

        verify(ownerDAO, times(1)).save(owner);
    }

    @Test
    public void testDeleteOwner() {
        HibernateIOwnerDAO ownerDAO = Mockito.mock(HibernateIOwnerDAO.class);
        OwnerService ownerService = new OwnerService(ownerDAO);

        Owner owner = new Owner("Test Owner", new Date(), Sex.GENDER_FLUID, cats);

        when(ownerDAO.findById(1)).thenReturn(owner);

        ownerService.deleteOwner(owner);

        verify(ownerDAO, times(1)).delete(owner);
    }
}