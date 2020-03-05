import org.graalvm.compiler.debug.Assertions;
import org.junit.Assert;
import org.junit.Test;

public class PasswordCheckerTest {
    @Test
    public void TestPasswordValid() throws Exception {
        PasswordChecker p =new PasswordChecker();
        Assertions.assertThrows(Exception.class, () -> p.passwordIsValid("Umuzicohort2"){
            ;});

    }
    @Test
    public void TestPasswordIsOk(){
        PasswordChecker p = new PasswordChecker();
        Assert.assertTrue(p.passwordIsOk("Umuzicohort2"),true);
    }
}
