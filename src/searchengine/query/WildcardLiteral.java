package searchengine.query;

import searchengine.index.Index;
import searchengine.index.KGramIndex;
import searchengine.index.Posting;
import mainapp.Indexer;

import java.util.List;

public class WildcardLiteral implements Query {

    private String mTerm;

    public WildcardLiteral(String term) {
        mTerm = term;
    }

    public String getTerm() {
        return mTerm;
    }

    @Override
    public List<Posting> getPostings(Index index) {
        List<String> grams = KGramIndex.getGrams(Indexer.K_GRAM_LIMIT, mTerm);
        for (String gram : grams) {
            System.out.println(gram);
        }
        return index.getPostings(mTerm);
    }

    @Override
    public String toString() {
        return mTerm;
    }
}