package collections;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

class UrlLibrary implements Iterable<String> {
	private List<String> urls = new LinkedList<String>();

	public UrlLibrary() {
		urls.add("http://www.google.com");
		urls.add("http://www.facebook.com");
		urls.add("http://www.ndtv.com");
		urls.add("http://www.timesofindia.com");
	}

	@Override
	public Iterator<String> iterator() {
		// TODO Auto-generated method stub
		return urls.iterator();
	}

}

class UrlLibrary2 implements Iterable<String> {
	private List<String> urls = new LinkedList<String>();
	
	public class UrlIterator implements Iterator<String> {
		private int index = 0;

		@Override
		public boolean hasNext() {
			return index < urls.size();
		}

		@Override
		public String next() {
			StringBuilder sb = new StringBuilder();
			BufferedReader br = null;

			try {
				URL url = new URL(urls.get(index));
				br = new BufferedReader(new InputStreamReader(url.openStream()));

				String line = null;
				while((line = br.readLine()) != null) {
					sb.append(line);
					sb.append("\n");
				}
				
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				if (br != null)
					try {
						br.close();
					} catch (IOException e) {
						e.printStackTrace();
					}
			}

			index++;

			return sb.toString();
		}

		@Override
		public void remove() {
			urls.remove(index);
		}
		
	}

	public UrlLibrary2() {
		urls.add("http://www.google.com");
		urls.add("http://www.facebook.com");
		urls.add("http://www.ndtv.com");
		urls.add("http://www.timesofindia.com");
	}

	@Override
	public Iterator<String> iterator() {
		// TODO Auto-generated method stub
		return new UrlIterator();
	}

}

public class L11Iterable {

	public static void main(String[] args) {
		UrlLibrary urlLibrary = new UrlLibrary();

		for(String url: urlLibrary)
			System.out.println(url);
		
		UrlLibrary2 urlLibrary2 = new UrlLibrary2();
		for(String url: urlLibrary2)
			System.out.println(url);

	}

}
