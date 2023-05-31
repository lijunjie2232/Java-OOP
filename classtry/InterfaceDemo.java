import java.util.HashMap;
import java.util.Map;

public class InterfaceDemo {
    public static void main(String[] args) throws Exception {
        try {
            if (args[1].toLowerCase().equals("man")) {
                Map<String, String> config = new HashMap<String, String>();
                config.put("namae", (String) args[0]);
                PersonInt person = new PeopleProxy(new ManClass(), config);
                person.show();
            } else if (args[1].toLowerCase().equals("woman")) {
                Map<String, String> config = new HashMap<String, String>();
                config.put("namae", (String) args[0]);
                PersonInt person = new PeopleProxy(new WomanClass(), config);
                person.show();
            } else {
                throw new Exception("no such type of a person");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

interface PersonInt {
    public abstract void show();
}

abstract class PeopleAbst implements PersonInt {
    public abstract void show();

    public abstract void setNamae(String namae);

    public abstract String getNamae();
}

class ManClass extends PeopleAbst {
    private String namae;

    @Override
    public void setNamae(String namae) {
        this.namae = namae;
    }

    @Override
    public String getNamae() {
        return this.namae;
    }

    @Override
    public void show() {
        System.out.println("man " + this.getNamae());
    }
}

class WomanClass extends PeopleAbst {
    private String namae;

    @Override
    public void setNamae(String namae) {
        this.namae = namae;
    }

    @Override
    public String getNamae() {
        return this.namae;
    }

    @Override
    public void show() {
        System.out.println("women " + this.getNamae());
    }
}

class PeopleProxy extends PeopleAbst {
    private PeopleAbst person;

    public PeopleProxy(PeopleAbst person, Map<String, String> config) {
        System.out.println("init environment");
        this.person = person;
        this.setNamae((String) config.get("namae"));
        System.out.println("other progress of a people");
    }

    public void setNamae(String namae) {
        this.person.setNamae(namae);
    }

    public String getNamae() {
        return this.person.getNamae();
    }

    public void show() {
        this.person.show();
    }
}
