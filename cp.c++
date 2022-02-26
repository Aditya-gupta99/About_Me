#include<bits/stdc++.h>
using namespace std;
typedef long long int ll;
typedef vector<int> vi;
typedef pair<int,int> pii;


int main()
{
 
    int n,diff=0,maxi=0;
    cin>>n;
    int a[n] , b[n+2];
    for(int i=0;i<n;i++)
    {
        cin>>a[i];
    
    }
    b[0]=0;
    for(int i=0; i<n;i++)
    {
        b[i+1]=b[i]+a[i];
        if(b[i+1]>=360)
        {
            b[i+1]=b[i+1]-360;
        }
    }

    b[n+1]=360;
    sort(b,b+n+2);
    for(int i=0;i<=n;i++)
    {
        diff=b[i+1]-b[i];

        maxi=max(maxi,diff);
    }

    cout<<maxi<<endl;
}