<p >Summary</p>
<ul type="disc" >
    <li >Arrays are a contiguous block of memory where elements are stored at consecutive memory locations. Each element is accessed via an index (typically starting at 0).</li>
    <li >Memory Access:
        <ul type="circle" >
            <li >Access time for arrays is O(1) (constant time) because elements are contiguous.</li>
            <li >&nbsp;The address of an element can be calculated by adding the product of the index and element size to the base address of the array.</li>
        </ul>
    </li>
    <li >Types:
        <ul type="circle" >
            <li >&nbsp;Size is fixed at compile time.</li>
            <li >&nbsp;Size is determined at runtime (e.g., vectors in C++ or ArrayLists in Java).</li>
        </ul>
    </li>
</ul>
<p >Key Questions on Arrays</p>
<ol start="1" type="1" >
    <li >What is an array?
        <ul type="circle" >
            <li >A data structure where elements are stored in consecutive memory locations and accessed by an index.</li>
        </ul>
    </li>
    <li >How is an element accessed in an array?
        <ul type="circle" >
            <li >By calculating its memory address using the index and element size.</li>
        </ul>
    </li>
    <li >How does a dynamic array differ from a static array?
        <ul type="circle" >
            <li >Dynamic arrays are resized during runtime (with an amortized constant time for appending), while static arrays have a fixed size.</li>
        </ul>
    </li>
    <li >How do 2D arrays work?
        <ul type="circle" >
            <li >2D arrays are arrays of arrays, and their elements are accessed in a row-major or column-major order.</li>
        </ul>
    </li>
    <li >How can you rotate an array efficiently?
        <ul type="circle" >
            <li >Use a two-pointer technique or array splitting for optimized rotation. An in-place rotation can be achieved with O(n) time complexity.</li>
        </ul>
    </li>
</ol>
<p >Advanced Topics in Arrays</p>
<ol start="1" type="1" >
    <li >Memory Alignment:
        <ul type="circle" >
            <li >Arrays benefit from proper memory alignment for efficient CPU access. Misalignment can lead to performance penalties.</li>
        </ul>
    </li>
    <li >Cache Friendliness:
        <ul type="circle" >
            <li >Arrays are cache-friendly because of contiguous memory storage, which enables CPUs to prefetch adjacent elements efficiently.</li>
        </ul>
    </li>
    <li >Cycle Detection:
        <ul type="circle" >
            <li >< >&nbsp;is used to detect cycles in data structures like linked lists or arrays (when elements point to other indices). It uses two pointers (slow and fast) to detect cycles in O(n) time and O(1) space.</li>
        </ul>
    </li>
    <li >Multidimensional Arrays:
        <ul type="circle" >
            <li >2D arrays are stored as a single contiguous block. In row-major order, to access an element, you calculate the offset based on the number of rows and columns.</li>
        </ul>
    </li>
    <li >Tricky Index Calculation:
        <ul type="circle" >
            <li >If an array&apos;s indices start from a non-zero value, adjust the address calculation by subtracting the starting index from the current index to get the correct memory location.</li>
        </ul>
    </li>
</ol>
<p >Optimized Techniques &amp; Space Considerations</p>
<ul type="disc" >
    <li >&nbsp;Instead of rotating an array k times, split the array into two parts and swap them in one go.</li>
    <li >&nbsp;Use a set to track visited nodes/indices, but this requires O(n) space. Alternatively, Floyd&rsquo;s algorithm is O(1) space.</li>
</ul>