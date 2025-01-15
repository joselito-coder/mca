import sklearn
import pandas
from scipy.io import arff
import sklearn.linear_model
import sklearn.metrics
import sklearn.model_selection
import sklearn.preprocessing


#  plot the data

file = arff.loadarff('rice.arff')

df = pandas.DataFrame(file[0]);



X = df.iloc[:,:7]
Y = df.iloc[:,7:]


X_train,X_test,Y_train,Y_test = sklearn.model_selection.train_test_split(X,Y,random_state=0,test_size=0.25)



le = sklearn.preprocessing.LabelEncoder()
Y_train = le.fit_transform(Y_train.values.ravel())
Y_test = le.fit_transform(Y_test.values.ravel());

# X_train = le.fit_transform(X_train.values.ravel());


# print(Y_train);


cm = sklearn.linear_model.LogisticRegression(random_state=0,solver='lbfgs');
cm.fit(X_train,Y_train);

Y_pred = cm.predict(X_test);


print(Y_pred);


cm = sklearn.metrics.confusion_matrix(Y_test,Y_pred)

print(cm)

from sklearn.metrics import precision_score,recall_score,f1_score

precision = precision_score(Y_test,Y_pred,average='macro')
recall= recall_score(Y_test,Y_pred,average='macro')
fs = f1_score(Y_test,Y_pred,average='macro')


# print(recall,precision)
print(precision)
print(recall)
print(fs)