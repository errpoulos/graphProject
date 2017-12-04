public class Applicant extends Vertex {
    private String name;
    private int qualificationScore;

    /**
     * @param name The Unique label for this vertex.
     * @param qualificationScore
     */
    public Applicant(String name, int qualificationScore) {
        super(name);
        this.name = name;
        this.qualificationScore = qualificationScore;
    }


    public String getName() {
        name = super.getLabel();
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getQualificationScore() {
        return qualificationScore;
    }

    public void setQualificationScore(int qualificationScore) {
        this.qualificationScore = qualificationScore;
    }

    @Override
    public String toString() {
        return "Applicant{" +
                "name='" + name + '\'' +
                ", qualificationScore=" + qualificationScore +
                '}';
    }
}
