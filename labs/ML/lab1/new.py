from sklearn.model_selection import train_test_split
from sklearn.metrics import f1_score,recall_score,precision_score,confusion_matrix
from sklearn.preprocessing import StandardScaler,LabelEncoder
from scipy.io import arff
import pandas



file = arff.loadarff('rice.arff');
df = pandas.DataFrame(file[0]);

x = df.iloc[:,:7]
y = df.iloc[:,7:]


x_train,x_test,y_train,y_test = train_test_split(x,y,random_state=0,test_size=0.25)


sc = StandardScaler()
x_train = sc.fit_transform(x_train)
x_test = sc.fit_transform(x_test);


le = LabelEncoder()
y_train = le.fit_transform(y_train.values.ravel())
y_test = le.fit_transform(y_test.values.ravel())


from sklearn.linear_model import LogisticRegression

re = LogisticRegression(solver='lbfgs',random_state=0,multi_class='auto')

re.fit(x_train,y_train);


y_pred = re.predict(y_test);


print(y_pred)




