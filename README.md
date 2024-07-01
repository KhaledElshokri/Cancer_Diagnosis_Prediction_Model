# Cancer_Diagnosis_Prediction_Model

# I. CHARACTERIZATION OF THE PROBLEM 
The problem at hand involves designing and implementing a machine learning model to 
perform as accurate of a diagnosis as possible on a dataset consisting of 569 patient files. Each file
represents information about a patient's cell and its cancerous nature. The dataset includes 10 
attributes relevant to the diagnosis, a patient identifier (non-diagnostic), and a diagnosis label 
(malignant or benign). The main objective is to develop a k-nearest neighbor (k-NN) machine 
learning model, that can effectively classify instances with high accuracy even if it was not trained 
on the instance itself. The model's performance will be evaluated based on the accuracy of the 
diagnoses for instances not used during training. Also, the computational efficiency and scalability 
of the solution are important to consider in the design. To optimize the accuracy and efficiency of 
the model, we will make use of a tree-based data structure (KD-tree). This data structure aims to 
organize the instances in a certain way that enables efficient identification of nearest neighbors for 
a given instance, therefore improving the accuracy of the diagnosis. While accuracy takes 
precedence in the design, it is crucial to ensure computational efficiency and scalability to handle 
possibly larger datasets if the program was exposed to such datasets.

# II. DESCRIPTION OF THE MODEL
The main data structure used in this model is the KD-tree data structure, which is a type of 
a binary search tree, where each node is consisting of multiple dimensions instead of just one. In
the case of our model, the KD-tree has 10 dimensions defined by the 10 attributes that determine
the diagnosis label of each patient.
The training of the model will consist of selecting random sets of data, then organizing the 
data in a KD-tree structure. The testing of the model will consist of using the nearest neighbor 
4
search algorithm to find the closest data in the tree to our target (testing data), after finding an odd 
number of nearest neighbors, voting on the diagnosis label will take place, and the result of the 
voting will determine the potential diagnosis label of the target that our model predicts. Therefore, 
the accuracy of the model will be determined by comparing the prediction made by the model with 
the actual diagnosis label of the target. The model will be trained on 50, 150, 250, 350, and 450
datasets, and for each number of datasets, the model will be tested with 1/4 the number of datasets.
The following main data structure annotated diagram and high-level flowchart demonstrate the 
implementation of the model:
Figure 1 Annotated Diagram of The Main Data Structure
This diagram shows the KD-tree structure for the first four dimensions, when the depth of the tree 
gets to 10, the median is again calculated based on the first dimension, then the second for depth 
11, etc. Until there is no more patient data available to insert in the tree. Worth noting that each 
shown node always contains the 10 attributes, id, and diagnosis label of the patient.
5
The following high-level flowchart demonstrates the implementation of the main algorithms used 
to construct the KD tree:
Figure 2 Chart Flow of The Implementation of the KD-tree
After constructing the KD tree, we can start testing the model by setting a random target that
does not belong to the tree already. We test the model with 1/4 times the number of nodes in the 
6
tree. We do so by implementing a find nearest neighbor algorithm. Which is described in the 
following flow chart:
Figure 3 Flow Chart for nearest neighbor search
7
# III. RESULTS AND ANALYSIS
After writing the program and running it with the different data sets (50, 150, 250, 350, 
and 450) and with k-3,5, and 7 nearest neighbors, we have our results shown in the graphs below. 
Each graph consists of an x-axis which represents the data set which consists of information about 
a patient's cell that indicates whether it is malignant or not. The information includes the patient's 
ID (which is irrelevant to their diagnosis) and a diagnostic indicating whether the illness is 
malignant or benign. It also offers a set of ten features that are commonly used to make a diagnosis.
In addition, there are 2 y-axes. The 1
st one represents the time it takes to process each data set. A 
higher point on the time axis implies that the processing time is longer, while a lower point suggests 
that the processing time is quicker. The 2nd one represents the accuracy of the nearest neighbors’
predictions after each data set has been processed. A higher point on the accuracy axis implies 
more prediction accuracy, whereas a lower point indicates lesser prediction accuracy.
Figure 4 Graph for 3 nearest neighbors
0 50 100 150 200 250 300 350 400 450 500
0
10
20
30
40
50
60
70
80
90
100
0
10
20
30
40
50
60
70
0 50 100 150 200 250 300 350 400 450 500
Time (ms)
Number of data set (N)
Graph 1: Time and accuracy as a function of the number of 
training data sets for k = 3.
Time
Accuracy
8
In the 3 nearest neighbors’ graph, we can see that the time was increasing as the data set 
was increasing continuously and reached its peak at 58 ms. In addition, as the data set increased
from 50 to 250 the accuracy increased from 75% and reached 93.54 % but as the data set increased
from 250 to 450 the accuracy started decreasing from 93.54% and reached 88.39% at the 450 data 
set. Based on the description of the 3 nearest neighbors’ graph, we can conclude that there is a 
direct relationship between the size of the dataset and the processing time, with time increasing as 
the dataset size increases, peaking at 58 ms. In terms of accuracy, it appears that an optimal point 
is attained with a dataset size of 250 when the accuracy peaks at 93.54%. Beyond this threshold, 
however, the accuracy begins to decline, decreasing to 88.39% with a dataset size of 450. This 
implies that, while increasing the dataset size initially improves the accuracy of the 3 closest 
neighbors’ model, there is a limit (in this case, a dataset size of 250) beyond which additional 
increases in dataset size may potentially worsen the model's performance. The average accuracy
for the 3 nearest-neighbor graph is 84.76%.
Figure 5 Graph for 5 nearest neighbors
0 50 100 150 200 250 300 350 400 450 500
88
88.5
89
89.5
90
90.5
91
91.5
92
92.5
0
5
10
15
20
25
30
35
40
0 50 100 150 200 250 300 350 400 450 500
Time (ms)
Number of data set (N)
Graph 2: Time and accuracy as a function of the number of data 
set for k = 5.
Time
Accuracy
9
In the 5 nearest neighbors’ graph, we can see that the time was increasing as the data set was 
increasing continuously and reached its peak at 35 ms at data set 450. In addition, as the data set 
increased from 50 to 150 the accuracy increased from 91.66% to 91.9%. And as the data set
increased from 150 to 450 the accuracy started decreasing from 91.9% and reached 88.4% as its 
lowest accuracy. The model's processing time grows according to the size of the dataset. It hits its 
maximum for a dataset size of 450 at 35 ms. This implies that larger datasets require more 
computational time to process by the model. While increasing the dataset size initially improves 
the model's accuracy for this 5 closest neighbours’ model, there appears to be an inflection point 
(about a dataset size of 150) beyond which additional increases in dataset size led to a fall in 
accuracy. The average accuracy for the 5 nearest neighbor graph is 89.852%.
Figure 6 Graph for 7 nearest neighbors
In the 7 nearest neighbors’ graph, we can see that the time was increasing as the data set 
was increasing continuously and reached its maximum at 46 ms at data set 450. In addition, as the 
data set increased from 50 to 150 the accuracy increased from 91.66% to 94.6%. And as the data 
0 50 100 150 200 250 300 350 400 450 500
86
87
88
89
90
91
92
93
94
95
0
5
10
15
20
25
30
35
40
45
50
0 50 100 150 200 250 300 350 400 450 500
Time (ms)
Number of data set (N)
Graph 3: Time and accuracy as a function of the number of 
data set for k = 7.
Time
Accuracy
10
set increased from 150 to 450 the accuracy started decreasing from 94.6% and reached its lowest 
at 86.61% at data set 450. The amount of the dataset and the processing time have a direct 
relationship. As the dataset size grows, so does the processing time, eventually peaking at 46 ms
for a dataset size of 450. This implies that larger datasets will necessitate more processing time for 
this model. While increasing dataset size initially improves model accuracy for this 7 closest 
neighbors’ model, there appears to be an inflection point (in this case, around a dataset size of 
150), beyond which additional increases in dataset size led to a fall in accuracy. The average 
accuracy for the 7 nearest neighbor graph is 90.562%.
In conclusion, based on the average accuracy of each graph we can see that the 7 nearest 
neighbor graph is the most accurate with a percentage of 90.562%. However, the fluctuation in the 
accuracy results of the 3 graphs, might be due to several factors such as the shuffling of the data 
when distributing each data set in the node and it might be due to the computer processing. Thus, 
as the data set numbers get bigger there is more of a margin of error. And in all the graphs time 
was increasing continuously as data set numbers increased which is expected. 
# IV. CONCLUSION
To conclude, by training an AI model using a KD-tree, it is possible to predict with 
relatively high accuracy the diagnoses label of a patient using the 3, 5, and 7 nearest neighbor 
voting algorithms. The KD-tree data structure allowed us to organize the patients depending on
the 10 attributes that describe their diagnosis label, which provide the required information to
conduct a search nearest neighbor algorithm. After testing, the model’s accuracy is calculated by 
comparing the result of the voting algorithm with the actual diagnosis of the patient. For bigger 
data sets and higher dimensions of comparisons, the Ball-tree algorithm might be a better and 
faster solution to the problem
