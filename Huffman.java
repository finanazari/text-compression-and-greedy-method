import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.Comparator;

// Membuat class yang isinya struktur dasar dalam tree
class HuffmanNode {

	int data;
	char c;

	HuffmanNode left;
	HuffmanNode right;
}

// Membuat class yang akan membantu mengkomparasi node.
class MyComparator implements Comparator<HuffmanNode> {
	public int compare(HuffmanNode x, HuffmanNode y) {

		return x.data - y.data;
	}
}

public class Huffman {

	/*
	 * membuat function rekursif untuk meregenerasi node dari
	 * huffman traversal tree
	 */
	public static void printCode(HuffmanNode root, String s) {

		/*
		 * Jika node kiri dan kanan null atau kosong
		 * maka kita akan cetak hingga meregenerasi ke akar tree traversal
		 * huffman ini(huffman adalah pencipta algoritmanya dari universitas MIT luar
		 * negeri)
		 * tidak ada alasan khusus memberi nama treenya huffman
		 */
		if (root.left == null
				&& root.right == null
				&& Character.isLetter(root.c)) {

			// c adalah karakter yang nantinya ada di node
			System.out.println(root.c + ":" + s);

			return;// nanti akan mengembalikan nilai/method yang ada dalam function ini
		}

		// cetak "0" jika kearah node kiri
		// cetak "1" jika kearah node kanan

		/*
		 * Lakukan rekursif atau paggilan berulang untuk
		 * node kiri dan kanan secara regenarasi
		 */
		printCode(root.left, s + "0");
		printCode(root.right, s + "1");
	}

	// main function
	public static void main(String[] args) {

		Scanner s = new Scanner(System.in);

		// nomor characters.
		int n = 6;
		char[] charArray = { 'a', 'b', 'c', 'd', 'e', 'f' };
		int[] charfreq = { 1, 1, 1, 1, 1, 1 };

		// Buat object berupa heap yang akan menggabungkan 2 character
		PriorityQueue<HuffmanNode> q = new PriorityQueue<HuffmanNode>(n, new MyComparator());

		for (int i = 0; i < n; i++) {

			// Buat Object untuk node
			HuffmanNode hn = new HuffmanNode();

			hn.c = charArray[i];
			hn.data = charfreq[i];

			hn.left = null;
			hn.right = null;

			// method add untuk menambahkan nilai yang didalam object hn
			q.add(hn);
		}

		// deklarasikan nilai root node
		HuffmanNode root = null;

		/*
		 * berikut adalah method -method yang akan mengekstrak nilai
		 * 0 dan 1 untuk node kiri dan kanan
		 */
		while (q.size() > 1) {

			HuffmanNode x = q.peek();
			q.poll();

			HuffmanNode y = q.peek();
			q.poll();

			HuffmanNode f = new HuffmanNode();

			f.data = x.data + y.data;
			f.c = '-';

			f.left = x;

			f.right = y;
			root = f;

			q.add(f);
		}

		printCode(root, "");
	}
}
