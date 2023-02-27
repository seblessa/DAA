#include <iostream>
using namespace std;

int main()
{
    int T;
    cin >> T;

    for (int i = 0; i < T; i++)
    {
        int n;
        int target;

        cin >> n >> target;
        
        int sum=0;

        while (sum!=target)
        {
            n++;
            int copy=n;
            sum=0;
            while (copy>0)
            {
                sum+=copy%10;
                copy=copy/10;
            }

            // cout<<sum<< endl;
            
        }
        
        cout << n << endl;
    }
    return 0;
}
