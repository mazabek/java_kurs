package addressbook.generators;

import addressbook.model.ContactGroup;
import com.beust.jcommander.JCommander;
import com.beust.jcommander.Parameter;
import com.beust.jcommander.ParameterException;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.thoughtworks.xstream.XStream;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;

public class ContactDataGenerator {
    @Parameter (names = "-c", description = "Contact count")
    public int count;
    @Parameter (names = "-f", description = "Target file")
    public String file;
    @Parameter (names = "-d", description = "Data format")
    public String format;

    public static void  main(String[] args) throws IOException {
        ContactDataGenerator generator = new ContactDataGenerator();
        JCommander jCommander = new JCommander(generator);
        try{
            jCommander.parse(args);
        } catch (ParameterException ex){
            jCommander.usage();
            return;
        }

        generator.run();
    }

    private void run() throws IOException {
        List<ContactGroup> groupList = generateContacts (count);
        if(format.equals("csv")){
            saveAsCsv(groupList, new File(file));
        } else  if(format.equals("xml")){
            saveAsXml(groupList, new File(file));
        } if(format.equals("json")){
            saveAsJson(groupList, new File(file));
        } else {
            System.out.println("Unrecognized format " + format);
        }
    }

    private void saveAsJson(List<ContactGroup> groupList, File file) throws IOException {
        Gson gson = new GsonBuilder().setPrettyPrinting().excludeFieldsWithoutExposeAnnotation().create();
        String json = gson.toJson(groupList);
        try (Writer writer = new FileWriter(file)){
            writer.write(json);
        }
    }

    private void saveAsXml(List<ContactGroup> groupList, File file) throws IOException {
        XStream xstream = new XStream();
        xstream.processAnnotations(ContactGroup.class);
        String xml = xstream.toXML(groupList);
        try(Writer writer = new FileWriter(file)){
            writer.write(xml);
        }
    }

    private void saveAsCsv(List<ContactGroup> groupList, File file) throws IOException {
        System.out.println(new File(".").getAbsolutePath());
        try (Writer writer = new FileWriter(file)){
            for (ContactGroup contactGroup: groupList){
                writer.write(String.format("%s;%s;%s;%s;%s;%s;%s;%s;%s;%s\n", contactGroup.getFirstname(), contactGroup.getLastname(), contactGroup.getAddress(),
                        contactGroup.getTelhome(), contactGroup.getTelmobile(), contactGroup.getTelwork(), contactGroup.getEmail(), contactGroup.getEmail2(),
                        contactGroup.getEmail3(), contactGroup.getGroup()));
            }
        }
    }

    private List<ContactGroup> generateContacts(int count) {
        List<ContactGroup> groupList = new ArrayList<ContactGroup>();
        for(int i=0; i< count; i++){
            groupList.add(new ContactGroup().withFirstname(String.format("test %s", i)).withLastname(String.format("test %s", i))
                    .withAddress(String.format("test %s", i)).withTelhome(String.format("test %s", i)).withTelmobile(String.format("test %s", i))
                    .withTelwork(String.format("test %s", i)).withEmail(String.format("test %s", i)).withEmail2(String.format("test %s", i)).withEmail3(String.format("test %s", i))
                    .withGroup(String.format("test %s", i)));
        }
        return groupList;
    }

}
