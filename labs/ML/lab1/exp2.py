from ucimlrepo import fetch_ucirepo 
from sklearn.model_selection import train_test_split
from sklearn.metrics import precision_score
from sklearn.metrics import recall_score
from sklearn.metrics import f1_score
from sklearn.metrics import confusion_matrix
from sklearn.linear_model import LogisticRegression
from sklearn.preprocessing import StandardScaler
import pandas
from scipy.io import arff


"""
Step 1 get the dataset ( either using repos or from file)
"""

# fetch dataset 

file = arff.loadarff('rice.arff')

df = pandas.DataFrame(file[0])

  
# data (as pandas dataframes) 
features = df.iloc[:,:7]
targets = df.iloc[:,7]

# print(features)
# print(targets)



"""
Step 2 get the dataset split the data into training and testing
"""
 

featuresTrain,featuresTest,targetTrain,targetTest = train_test_split(features,targets,test_size=0.25,random_state=0)


# print(featuresTrain,featuresTest);


# exit()


"""
Step 3 normalize the data
"""

sc = StandardScaler()
featuresNormalizedTrain = sc.fit_transform(featuresTrain);
featuresNormalizedTest = sc.fit(featuresTest);


# transform the data
from sklearn.preprocessing import LabelEncoder
le = LabelEncoder()

targetTrain = le.fit_transform(targetTrain.values.ravel())
targetTest = le.fit_transform(targetTest.values.ravel())


"""
Step 4 train the model ( feed the data )  and get prediction
"""

cl = LogisticRegression(random_state=0,solver="lbfgs",multi_class='auto');
cl.fit(featuresTrain,targetTrain);

targetPrediction = cl.predict(featuresTest);


# print(targetPrediction);

"""
Step 5 plot the confusion matrix
"""


cm = confusion_matrix(targetTest,targetPrediction);
print(cm)


"""
Step 6  calculate precision , recall and f1 score
"""

precision = precision_score(targetTest,targetPrediction,average="macro")
recall = recall_score(targetTest,targetPrediction,average="macro")
f1 = f1_score(targetTest,targetPrediction,average="macro")


"""
Step 7  printing results
"""


# all print statements
print(f"Confusion matrix\n{cm}")
print(f"precision Score: {precision}")
print(f"Recall: {recall}")
print(f"f1 score: {f1}")
  
