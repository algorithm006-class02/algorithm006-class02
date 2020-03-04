class Solution {
public:
    //单向广度优先搜索
    int minMutation(string start, string end, vector<string>& bank) {
        if(start.size() < end.size())       //这种情况下是无论如何都不可能突变为目标基因的，直接返回-1
            return -1;
        std::string strGenes = "ACGT";  //基因变化的取值范围
        std::queue<std::pair<std::string,int>> queNode;       //队列中保存的是结点信息，key表示的是这个结点的值是什么,value表示的是由start经过了几次变化可以得到这个key，使用这种方式计算是为了避免广度优先搜索执行结束以后没有搜索到目标基因而导致错误的计数结果（这是不使用int iMinMutation = -1;单变量进行结果计数的理由）
        std::unordered_set<std::string> unsetBank(bank.begin(),bank.end()); //在后续的搜索中要通过查找bank来确定这一次的变化是否有效，使用hash表可以加快查找速度
        queNode.push({start,0});
        while(!queNode.empty())
        {
            auto pairGene = queNode.front();
            if(pairGene.first == end)
            {
                return pairGene.second;
            }
            queNode.pop();
            
            //在当前基因的基础上进行突变，每次只变化一个位置上的基因，如果有发现有效变化的情况则对计数器iMinMutation进行累加，有效变化指的是满足必须有一个位置发生了变化且变化的结果一定在基因库bank中
            
            //对每一个Byte进行变化，变化只能是"ACGT"中的一个
            for(int iIndex = 0; iIndex < pairGene.first.size(); ++iIndex)
            {
                char c = pairGene.first[iIndex]; //每次只能变化一个Byte，所以变完还得还原，这样这一个for循环的变化产生的结果才在同一层上
                for(const auto &gene : strGenes)
                {
                    //变化
                    //如果gene和目标位置iIndex上的值相同，说明这一位置原本就是这样，不需要变化
                    if(gene == pairGene.first[iIndex])
                        continue;
                    pairGene.first[iIndex] = gene;
                    if(unsetBank.end() != unsetBank.find(pairGene.first))
                    {
                        queNode.push({pairGene.first,pairGene.second + 1});
                        unsetBank.erase(pairGene.first);    //确保每个结点只被访问一次
                    }
                }
                //恢复状态
                pairGene.first[iIndex] = c;
            }
            
        }
        return -1;
    }
};
