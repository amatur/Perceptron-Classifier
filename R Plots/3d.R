traindata = read.table("train1.txt")
testdata = read.table("test1.txt")

colnames(traindata) <- c("A1","A2","A3", "C")
colnames(testdata) <- c("A1","A2","A3", "C")

class1train<-subset(traindata, C==1)
class2train<-subset(traindata, C==2)

class1test<-subset(testdata, C==1)
class2test<-subset(testdata, C==2)

#print(class1set)

# print(mydata[i, "C"])
# for (i in 1:nrow(mydata)){
#     
#   
# }


library("car")
library("rgl")
library(rgl)
#scatter3d(formula, data)
#scatter3d(mydata$A1, mydata$A2, mydata$A3)

### Create some dummy data
#dat <- replicate(2, 1:3)

### Initialize the scene, no data plotted
plot3d(dat, type = 'n', xlim = c(-1, 1), ylim = c(-1, 1), zlim = c(-3, 3), xlab = 'A1', ylab = 'A2', zlab = 'A3') 

# Add planes
planes3d(1004160.9000000001, 897415.1000000003, 710352.7999999999, col = 'red', alpha = 0.6)
#planes3d(1, -1, 1, 0, col = 'orange', alpha = 0.6)
#planes3d(1, -1, -1, -0.8, col = 'blue', alpha = 0.6)

# 
# points3d(class1train$A1, class1train$A2, class1train$A3, col = 'red')
# points3d(class2train$A1, class2train$A2, class2train$A3, col = 'blue')
# 

points3d(class1test$A1, class1test$A2, class1test$A3, col = 'orange')
points3d(class2test$A1, class2test$A2, class2test$A3, col = 'black')

#points3d(mydata$A1, mydata$A2, mydata$A3)
#planes3d(-21.134410561055905,-247.7977125808294,-32.03522900504822, 0)