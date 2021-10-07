package seedu.address.model.person;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static seedu.address.testutil.Assert.assertThrows;

import org.junit.jupiter.api.Test;

import seedu.address.model.person.exceptions.InvalidIdException;
import seedu.address.model.room.RoomNumber;

public class IdTest {

    @Test
    public void constructor_invalidId_throwsInvalidIdException() {
        //should throw an error since IDs are supposed to non-negative
        assertThrows(InvalidIdException.class, () -> Id.of(-1));
    }

    @Test
    public void constructor_invalidSetNextId_throwsInvalidIdException() {
        //should throw an error since IDs are supposed to non-negative
        assertThrows(InvalidIdException.class, () -> Id.setNextId(-1));
    }

    @Test
    public void isValidId() {
        assertFalse(Id.isValidId(-1));
        assertTrue(Id.isValidId(0));
    }

    @Test
    public void isSameId() {
        Id idOne = Id.of(1);

        // nextId parameter starts at 0. calling empty .of() created a new Id based on current nextId value and
        // automatically increments nextId by 1
        Id idZero = Id.of(0);
        Id idOneSame = Id.of(1);

        assertFalse(idOne.equals(idZero));
        assertTrue(idOne.equals(idOneSame));
    }

    @Test
    public void sameIdTest() {
        Id idZero = Id.of(0);
        Id idZeroSame = Id.of(0);
        Id idOne = Id.of(1);

        assertTrue(idZeroSame.equals(idZero));
        assertFalse(idZero.equals(idOne));
    }

    @Test
    public void getValueTest() {
        Id idZero = Id.of(0);
        Id idZeroSame = Id.of(0);
        Id idOne = Id.of(1);

        assertTrue(idZeroSame.getValue() == idZero.getValue());
        assertFalse(idZero.getValue() == idOne.getValue());
    }

    @Test
    public void equalsTest() {
        Id idZero = Id.of(0);
        Id idZeroSame = Id.of(0);
        Id idOne = Id.of(1);
        RoomNumber roomNumber = new RoomNumber("005");

        assertTrue(idZero.equals(idZero));
        assertTrue(idZeroSame.equals(idZero));
        assertFalse(idZero.equals(idOne));
        assertFalse(idZero.equals(roomNumber));
    }

    @Test
    public void hashcodeTest() {
        Id idZero = Id.of(0);
        Id idZeroSame = Id.of(0);
        Id idOne = Id.of(1);

        assertTrue(idZeroSame.hashCode() == idZero.hashCode());
        assertFalse(idZero.hashCode() == idOne.hashCode());
    }
}
