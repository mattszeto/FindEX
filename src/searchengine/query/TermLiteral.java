package searchengine.query;

import searchengine.index.Index;
import searchengine.index.KGram;
import searchengine.index.Posting;
import searchengine.text.AdvancedTokenProcesser;

import java.util.ArrayList;
import java.util.List;

/**
 * A TermLiteral represents a single term in a subquery.
 */
public class TermLiteral implements Query {
	private String mTerm;
	
	public TermLiteral(String term) {
		mTerm = term;
	}
	
	public String getTerm() {
		return mTerm;
	}
	
	@Override
	public List<Posting> getPostings(Index index, KGram kGramIndex) {
		//process token for valid characters
		AdvancedTokenProcesser processor = new AdvancedTokenProcesser();
		List<String> terms = processor.processToken(mTerm);
		for (int i = 0; i < terms.size(); i++) {
			terms.set(i, AdvancedTokenProcesser.stemToken(terms.get(i)));//stem the token
		}
		//collect the postings for the term
		List<Posting> result = new ArrayList<Posting>();
		for (String term: terms) {
			if (index.getPostings(term) != null) {
				result.addAll(index.getPostings(term));
			}
		}
		return result;
	}

	@Override
	public List<Posting> getPostingsPositions(Index index, KGram kGramIndex) {
		//process token for valid characters
		AdvancedTokenProcesser processor = new AdvancedTokenProcesser();
		List<String> terms = processor.processToken(mTerm);
		for (int i = 0; i < terms.size(); i++) {
			terms.set(i, AdvancedTokenProcesser.stemToken(terms.get(i)));//stem the token
		}
		//collect the postings for the term
		List<Posting> result = new ArrayList<Posting>();
		for (String term: terms) {
			if (index.getPostingsPositions(term) != null) {
				result.addAll(index.getPostingsPositions(term));
			}
		}
		return result;
	}
	
	@Override
	public String toString() {
		return mTerm;
	}
}
