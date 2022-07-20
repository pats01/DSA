static void quadratic_probing(int arr[], int size, int hash_table[],
int tsize) {
for(int i = 0; i < size; i++) {
int hash_value = arr[i] % tsize;
System.out.println(arr[i] + "%" + tsize + " = " +
hash_value);
if (hash_table[hash_value] == -1) {
hash_table[hash_value] = arr[i];
System.out.println("Inserted at " +hash_value);
System.out.println("--------------------------");
}
else {
int t = 0;
for(int j = 0; j < tsize; j++) {
t = (hash_value + j * j) % tsize;
System.out.println(hash_value + "+" +j + "^2" +"%"+
tsize + " = " + t);
if (hash_table[t] == -1) {
hash_table[t] = arr[i];
break;

}
}
System.out.println("Inserted at " +t);
System.out.println("--------------------------");
}
}
