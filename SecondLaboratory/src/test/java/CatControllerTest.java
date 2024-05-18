import org.example.dao.HibernateICatDAO;
import org.example.model.Cat;
import org.example.model.Owner;
import org.example.model.Sex;
import org.example.service.CatService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.awt.*;
import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class CatControllerTest {
    private List<Cat> OwnersCats;
    private List<Cat> friends;
    @Test
    public void testGetCat() {
        HibernateICatDAO catDAO = Mockito.mock(HibernateICatDAO.class);
        Owner owner = new Owner("Test owner", new Date(), Sex.TRANS_FEMALE, OwnersCats);

        Cat cat = new Cat("Test Name",
                new Date(),
                Sex.INTERSEX,
                "Japanese",
                Color.BLACK,
                owner,
                friends);

        when(catDAO.findById(1)).thenReturn(cat);

        CatService catService = new CatService(catDAO);

        Cat result = catService.getCat(1);
        assertEquals(cat, result);

        verify(catDAO, times(1)).findById(1);
    }

    @Test
    public void testSaveCat() {
        HibernateICatDAO catDAO = Mockito.mock(HibernateICatDAO.class);
        Owner owner = new Owner("Test owner", new Date(), Sex.NON_BINARY, OwnersCats);

        Cat cat = new Cat("Test Name",
                new Date(),
                Sex.BIGENDER,
                "No breed",
                Color.white,
                owner,
                friends);

        CatService catService = new CatService(catDAO);

        catService.saveCat(cat);

        verify(catDAO, times(1)).save(cat);
    }

    @Test
    public void testUpdateCat() {
        HibernateICatDAO catDAO = Mockito.mock(HibernateICatDAO.class);
        Owner owner = new Owner("Test owner", new Date(), Sex.CIS, OwnersCats);

        Cat cat = new Cat("Test Name",
                new Date(),
                Sex.TRANS,
                "No breed",
                Color.red,
                owner,
                friends);

        CatService catService = new CatService(catDAO);

        catService.saveCat(cat);

        verify(catDAO, times(1)).save(cat);
    }

    @Test
    public void testDeleteCat() {
        HibernateICatDAO catDAO = Mockito.mock(HibernateICatDAO.class);
        Owner owner = new Owner("Test owner", new Date(), Sex.ANDROGYNE, OwnersCats);

        Cat cat = new Cat("Test Name",
                new Date(),
                Sex.CISGENDER_MALE,
                "No breed",
                Color.BLACK,
                owner,
                friends);

        CatService catService = new CatService(catDAO);

        catService.deleteCat(cat);

        verify(catDAO, times(1)).delete(cat);
    }
}