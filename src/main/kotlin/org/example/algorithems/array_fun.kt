package org.example.algorithems

object  array_fun {
    @JvmStatic
    fun main(args: Array<String>) {
        //int[] a = new int[]{5, -54, 5, 5454, 5, 1, 9, 87, 26, 69, 98, 1, 3};
        /*int[] a = randomArray(50000000)[0];
        long start = System.currentTimeMillis();
        int[] k=new int[a.length];
        for (int i = 0; i < a.length; i++) {
            k[i]=a[i];
        }
        //find_possible_sum(a[0],192);
        int[] b = new int[]{5, -54, 5, 5454, 5, 1, 9, 87, 26, 69, 98, 1, 3};
        System.out.println(Arrays.toString(remove_repeated_element(a)));
        System.out.println(System.currentTimeMillis() - start);
        System.out.println("Copied");
        start = System.currentTimeMillis();
       // var k2 = algo(a);
        //System.out.println(System.currentTimeMillis() - start);
        //System.out.println(Arrays.toString(k1));
        //System.out.println(Arrays.toString(k2));
*/
        println(Is_walkable(intArrayOf(4, 3, 0, 2, 1, 5, 3)))
    }

    fun algo(arr: IntArray): IntArray {
        val nArr = IntArray(arr.size)
        nArr[0] = arr[0]
        var k = 1
        for (i in 1 until arr.size) {
            var c = 0
            for (j in 0 until k) {
                val value = nArr[j]
                if (arr[i] == value) {
                    c++
                    break
                }
            }
            if (c == 0) {
                nArr[k] = arr[i]
                k++
            }
        }
        return nArr
    }

    private fun randomArray(n: Int): Array<IntArray> {
        val a = IntArray(n)
        val b = IntArray(n)
        for (j in 0 until n) {
            val con = (Math.random() * (n - j) + 2).toInt()
            a[j] = con
            b[j] = con
        }
        println("Array is filled")
        return arrayOf(a, b)
    }

    fun remove_repeated_element(arr: IntArray): IntArray {
        val nArr = IntArray(arr.size)
        var start: Int
        var end: Int
        var mid = 0
        var k = 0
        nArr[0] = arr[0]
        for (i in 1 until arr.size) {
            if (arr[i] > nArr[k]) {
                nArr[k + 1] = arr[i]
                k++
            } else if (arr[i] < nArr[0]) {
                System.arraycopy(nArr, 0, nArr, 1, k + 1)
                nArr[0] = arr[i]
                k++
            } else if (nArr[0] != arr[i] && nArr[k] != arr[i]) {
                end = k
                start = 0
                while (end - start != 1) {
                    mid = (end + start) / 2
                    if (arr[i] == nArr[mid]) break else if (nArr[mid] > arr[i]) end =
                        mid else if (nArr[mid] < arr[i]) start = mid
                }
                if (nArr[mid] < arr[i]) {
                    if (k + 1 - (mid + 1) >= 0) System.arraycopy(nArr, mid + 1, nArr, mid + 1 + 1, k + 1 - (mid + 1))
                    nArr[mid + 1] = arr[i]
                    k++
                } else if (nArr[mid] > arr[i]) {
                    if (k + 1 - mid >= 0) System.arraycopy(nArr, mid, nArr, mid + 1, k + 1 - mid)
                    nArr[mid] = arr[i]
                    k++
                }
            }
        }
        return nArr
    }

    fun binary_sort(arr: IntArray): IntArray {
        val nArr = IntArray(arr.size)
        var start: Int
        var end: Int
        var mid = 0
        var k = 0
        nArr[0] = arr[0]
        for (i in 1 until arr.size) {
            if (arr[i] >= nArr[k]) {
                nArr[k + 1] = arr[i]
                k++
            } else if (arr[i] <= nArr[0]) {
                System.arraycopy(nArr, 0, nArr, 1, k + 1)
                nArr[0] = arr[i]
                k++
            } else {
                end = k
                start = 0
                while (end - start != 1) {
                    mid = (end + start) / 2
                    if (arr[i] == nArr[mid]) {
                        if (k + 1 - (mid + 1) >= 0) System.arraycopy(
                            nArr,
                            mid + 1,
                            nArr,
                            mid + 1 + 1,
                            k + 1 - (mid + 1)
                        )
                        nArr[mid + 1] = arr[i]
                        k++
                        break
                    } else if (nArr[mid] > arr[i]) end = mid else if (nArr[mid] < arr[i]) start = mid
                }
                if (nArr[mid] < arr[i]) {
                    if (k + 1 - (mid + 1) >= 0) System.arraycopy(nArr, mid + 1, nArr, mid + 1 + 1, k + 1 - (mid + 1))
                    nArr[mid + 1] = arr[i]
                    k++
                } else if (nArr[mid] > arr[i]) {
                    if (k + 1 - mid >= 0) System.arraycopy(nArr, mid, nArr, mid + 1, k + 1 - mid)
                    nArr[mid] = arr[i]
                    k++
                }
            }
        }
        return nArr
    }

    private fun find_possible_sum(a: IntArray, n: Int) {
        for (i in a.indices) {
            for (j in i + 1 until a.size) {
                if (a[i] + a[j] == n) {
                    println(a[i].toString() + "       " + a[j])
                }
            }
        }
    }

    private fun Is_walkable(a: IntArray): Boolean {
        var i = a[0]
        var c = 0
        while (i >= 0 && i < a.size && a[i] >= 0) {
            val k = i
            i = a[i]
            a[k] = -1
            c++
        }
        return c == a.size
    }
}