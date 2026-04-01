/*
 * Activity 4.1.3
 *
 * Data attribute:
 * The World Bank:GDP (current US$): OECD National Accounts data files, CC BY 4.0
 */
import java.io.IOException;
import java.util.ArrayList;

public class GDP
{
    public static void main(String[] args) throws IOException
    {
        ArrayList<GDPData> data = GDPData.createDataSet("4.1\\GDP\\gdp_per_capita.csv");

        /*for (GDPData i : data) {
            System.out.println(i);
        }*/

        System.out.println(data.get(GDPSearch.find(data, 0, data.size() - 1, "Australia")));
        System.out.println(data.get(GDPSearch.find(data, 0, data.size() - 1, "Brazil")));
        System.out.println(data.get(GDPSearch.find(data, 0, data.size() - 1, "China")));
        System.out.println(data.get(GDPSearch.find(data, 0, data.size() - 1, "Germany")));
        System.out.println(data.get(GDPSearch.find(data, 0, data.size() - 1, "South Africa")));
        System.out.println(data.get(GDPSearch.find(data, 0, data.size() - 1, "United States")));

        double max = data.get(0).getGdpLast();
        int maxIndex = 0;
        for (int i = 0; i < data.size(); i++) {
            if (data.get(i).getGdpLast() > max) {
                max = data.get(i).getGdpLast();
                maxIndex = i;
            }
        }

        System.out.println(data.get(maxIndex));

        double max2 = 0;
        int maxIndex2 = 0;
        for (int i = 0; i < data.size(); i++) {
            GDPData j = data.get(i);
            double init = j.getGdpFirst();
            double end = j.getGdpLast();
            double difference = end - init;
            if (difference > max2) {
                max2 = difference;
                maxIndex2 = i;
            }
        }

        System.out.println(data.get(maxIndex2));

        GDPData usData = data.get(GDPSearch.find(data, 0, data.size() - 1, "United States"));
        double usGrowth = usData.getGdpLast() - usData.getGdpFirst();

        for (GDPData i : data) {
            double growth = i.getGdpLast() - i.getGdpFirst();
            if (growth > usGrowth) System.out.println(i);
        }
    }
}