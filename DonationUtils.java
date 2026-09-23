import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class DonationUtils {

    public static ArrayList<TotalDonation> aggregateDonations(ArrayList<Donation> donations) {
        if (donations == null || donations.isEmpty()) {
            return new ArrayList<>();
        }   
        
        HashMap<String, TotalDonation> totals = new HashMap<>();

        for (Donation donation: donations){
            if(donation == null || donation.getUser() == null || donation.getAmount() < 0){
                return new ArrayList<>();
            } 
        }

        for (Donation donation: donations){
            if (totals.containsKey(donation.getUser())){
                TotalDonation total = totals.get(donation.getUser());
                total.setCount(total.getCount() + 1);
                total.setAmount(total.getAmount() + donation.getAmount());
            }
            else{
                TotalDonation newTotal = new TotalDonation (donation.getUser(), donation.getAmount(), 1);
                totals.put(donation.getUser(), newTotal);
            }
        }

        
        return new ArrayList<>(totals.values());
        
    }


public static void main(String[] args) {
    ArrayList<Donation> testDonations = new ArrayList<>();
    ArrayList<Donation> negativeDonation = new ArrayList<>();
    ArrayList<Donation> nullTest = null;
    ArrayList<Donation> nullUser = new ArrayList<>();
    ArrayList<Donation> errorDonations = new ArrayList<>();

    testDonations.add(new Donation("Peppa", 200.50));
    testDonations.add(new Donation("Snoopy", 12.0));
    testDonations.add(new Donation("Peppa", 82.25));


    negativeDonation.add(new Donation("Tensae", -150));
    nullUser.add(new Donation(null, 50));
    errorDonations.add(null);

    ArrayList<TotalDonation> result = aggregateDonations(testDonations);
    ArrayList<TotalDonation> result2 = aggregateDonations(negativeDonation);
    ArrayList<TotalDonation> result3 = aggregateDonations(nullTest);
    ArrayList<TotalDonation> result4 = aggregateDonations(nullUser);
    ArrayList<TotalDonation> result5 = aggregateDonations(errorDonations);

    System.out.println(result);
    System.out.println(result2);
    System.out.println(result3);
    System.out.println(result4);
    System.out.println(result5);

    }

}