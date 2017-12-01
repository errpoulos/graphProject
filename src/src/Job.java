public class Job extends Vertex {

    public String title;
    public int qualificationRequirement;

    public Job(String label) {
        super(label);
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return "Job{" +
                "title='" + title + '\'' +
                ", qualificationRequirement=" + qualificationRequirement +
                '}';
    }
}

