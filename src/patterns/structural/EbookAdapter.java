package patterns.structural;

public class EbookAdapter implements EbookInterface {
    private final EbookService ebookService;

    public EbookAdapter(EbookService ebookService) {
        this.ebookService = ebookService;
    }

    @Override
    public String getEbook() {
        return ebookService.fetchEbook();
    }
}
