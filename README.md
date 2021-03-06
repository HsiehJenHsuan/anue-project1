anue-project1
====

### 目標

研究各式Java框架，採用任意一種，並將先前工作開發的API轉換成Java語言

-----

### 思路

一開始先以survey框架為主，並希望儘快找回當初寫Java的感覺

考量到以後系統可能的需求，一開始主要想找尋適用於高流量與高併發量系統之框架

在過程中survey了不少框架，包含Spring、Spring MVC、 Spring Boot、Spark、Dropwizard、Jersey...等等

而絕大部分框架都把重點放在輕量級、容易開發、模組化、前端渲染等功能，較少提到關於流量或效能等問題

因此一開始在框架的選擇上花了些時間苦惱

--

但是在仔細思索過後，發現自己似乎對於高流量系統與框架的意義有了些誤解

就我的理解，框架的本質在於開發，在開發中選擇一套框架主要的目的不是增進效能，而是

+ 遵循框架規範，不用花時間去思考諸如MVC架構位置等等問題
+ 達成降低耦合、模組化...等效用，加速開發與便於維護
+ 不同工程師在協作有同一套標準可以參照
+ 若需要由他人進行後續維護，只要找熟框架的人就可以迅速上手

而設計一套高流量的系統重點並不是在框架的選擇，而是在於更底層的問題，例如JVM的記憶體配置、前端負載平衡...等等

想從框架下手似乎是錯誤的...

--

在整理過想法後修正了框架選擇的原則，改成以開發速度為主

由於survey花了不少時間，加上仍要準備其他工作的面試，因此選擇框架的考量就變成了易於上手或能讓我更快速地完成這項任務

而Spring是曾經用過的框架，上手起來會稍微容易一些，而Boot包裝了常用的各式library以及方便的starter

因此最後評估過後決定採用Spring Boot作為開發框架

-----

### API說明

本支API主要負責處理靜態影片資料的存取

--

會選擇這支API的原因是當初在設計時嘗試將其建構成Facebook API的風格，是個有趣的經驗

FB的GraphAPI採用的也是帶辨別資料(user id)以及所需欄位，這個欄位是有彈性的

例如可以只要使用者姓名，或是姓名+照片，或是email+生日+頭像...等等，可以任意組合

把這個概念帶入到API中就會是傳入影片id以及想要取得的欄位，API就會將其包裝好回傳(欄位已經去識別化)

比較特別的地方在於實務上影片資料會存在不同的資料庫內，因此這部分也一起時做了進去

--

但原本DB的部分因為不是依照Codeigniter框架規範而是公司自己實作，保密考量下無法將架構直接實作

加上時間也不夠充足的關係，DB的部分就用最簡單的JDBC帶過去了

程式碼有些重複的地方也應該要修掉的，現在有些bad smell有點可惜

-----

### 結語

能夠透過這次小專案重新接觸Java是件很開心的事！

在玉山銀行使用的好像是Spring2還3，相較起來Spring Boot在開發上可以感覺到很大的進步

各種annotation的使用比起當初在寫的時候方便不少，也不需要一直進xml去設定DI，明顯感覺到時代的演進XD

而在survey的過程中對於Java的生態有較新的認識，更釐清了自己對於系統開發、架構和框架的一些看法

這次的專案實作對我來說有許多收穫，再次謝謝CC給予專案實作的機會！
