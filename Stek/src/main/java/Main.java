import java.io.IOException;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {

        List<AccrualSubscriber> accrualSubscribers = Service.accrualSubscribers(Service.parseAccrualSubscribers());
        List<String[]> data = Service.toStringArray(accrualSubscribers);
        Service.writeAccrualSubscribers(data);

        List<HomeAccrual> homeAccruals = Service.accrualHome(Service.parseHomeAccrual());
        List<String[]> home = Service.toStringArrayHome(Service.accrualsHomesDeleteZero(homeAccruals));
        Service.writeAccrualHomes(home);

    }
}
