package searchengine.query;
import searchengine.index.*;

import java.util.List;

/**
 * A Query is a piece or whole of a Boolean query, whether that piece is a literal string or represents a merging of
 * other queries. All nodes in a query parse tree are Query objects.
 */
public interface Query {
    /**
     * Retrieves a list of postings for the query, using an Index as the source.
     */
    List<Posting> getPostings(Index index, KGram kGramIndex);

    List<Posting> getPostingsPositions(Index index, KGram kGramIndex);
}